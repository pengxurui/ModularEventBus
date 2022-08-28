package com.pengxr.modular.eventbus.livedata.bus;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/**
 * LiveData base on KunMinX's version, it uses ObserverWrapper to solve sticky events.
 * This version is edit by pengxr: automatically clear livedata with no related observers.
 * <p>
 * {@see https://github.com/KunMinX/UnPeek-LiveData}
 */
@SuppressWarnings("unchecked")
class ProtectedUnPeekLiveData<T> extends LiveData<T> {

    private final static int START_VERSION = -1;

    private final AtomicInteger mCurrentVersion = new AtomicInteger(START_VERSION);

    protected String eventName;
    protected boolean isAllowNullValue;
    protected boolean isAutoClear;
    @Nullable
    protected NoObserverCallback noObserverCallback;

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        super.observe(owner, createObserverWrapper(observer, mCurrentVersion.get()));
    }

    @Override
    public void observeForever(@NonNull Observer<? super T> observer) {
        super.observeForever(createObserverWrapper(observer, mCurrentVersion.get()));
    }

    public void observeSticky(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer) {
        super.observe(owner, createObserverWrapper(observer, START_VERSION));
    }

    public void observeStickyForever(@NonNull Observer<? super T> observer) {
        super.observeForever(createObserverWrapper(observer, START_VERSION));
    }

    @Override
    protected void setValue(T value) {
        mCurrentVersion.getAndIncrement();
        super.setValue(value);
    }

    class ObserverWrapper implements Observer<T> {
        private final Observer<? super T> mObserver;
        private int mVersion;

        public ObserverWrapper(@NonNull Observer<? super T> observer, int version) {
            this.mObserver = observer;
            this.mVersion = version;
        }

        @Override
        public void onChanged(T t) {
            if (mCurrentVersion.get() > mVersion) {
                if (null == t && !isAllowNullValue) {
                    return;
                }
                mObserver.onChanged(t);
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ObserverWrapper that = (ObserverWrapper) o;
            return Objects.equals(mObserver, that.mObserver);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mObserver);
        }
    }

    // Automatically clear data, edited by pengxr on 13/8/2022

    /**
     * Tip: Both manual call and automatic call by Lifecycle will come here.
     */
    @Override
    @CallSuper
    public void removeObserver(@NonNull Observer<? super T> observer) {
        if (observer.getClass().isAssignableFrom(ObserverWrapper.class)) {
            removeObserverInternal((ObserverWrapper) observer);
        } else {
            removeObserverInternal(createObserverWrapper(observer, START_VERSION));
        }
    }

    private void removeObserverInternal(@NonNull ObserverWrapper observerWrapper) {
        super.removeObserver(observerWrapper);
        if (isAutoClear && !hasObservers()) {
            if (null != noObserverCallback) {
                noObserverCallback.onNoObserverAfterRemoved(this);
            }
        }
    }

    private ObserverWrapper createObserverWrapper(@NonNull Observer<? super T> observer, int version) {
        return new ObserverWrapper(observer, version);
    }

    public void clear() {
        super.setValue(null);
    }
}