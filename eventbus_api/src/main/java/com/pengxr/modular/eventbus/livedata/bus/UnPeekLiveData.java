package com.pengxr.modular.eventbus.livedata.bus;

import org.jetbrains.annotations.Nullable;

/**
 * LiveData base on KunMinX's version, it uses ObserverWrapper to solve sticky events.
 * This version is edit by pengxr to automatically clear livedata with no related observers.
 * <p>
 * {@see https://github.com/KunMinX/UnPeek-LiveData}
 */
class UnPeekLiveData<T> extends ProtectedUnPeekLiveData<T> {

    @Override
    public void setValue(T value) {
        super.setValue(value);
    }

    @Override
    public void postValue(T value) {
        super.postValue(value);
    }

    public static class Builder<T> {

        private String eventName;
        private boolean isAllowNullValue;
        private boolean isAutoClear;
        @Nullable
        private NoObserverCallback noObserverCallback;
        protected boolean throwNullEventException;

        public Builder<T> setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Builder<T> setAllowNullValue(boolean allowNullValue) {
            this.isAllowNullValue = allowNullValue;
            return this;
        }

        public Builder<T> setAutoClear(boolean autoClear) {
            isAutoClear = autoClear;
            return this;
        }

        public Builder<T> setNoObserverCallback(NoObserverCallback noObserverCallback) {
            this.noObserverCallback = noObserverCallback;
            return this;
        }

        public Builder<T> setThrowNullEventException(boolean throwNullEventException) {
            this.throwNullEventException = throwNullEventException;
            return this;
        }

        public UnPeekLiveData<T> create() {
            UnPeekLiveData<T> liveData = new UnPeekLiveData<>();
            liveData.eventName = this.eventName;
            liveData.isAllowNullValue = this.isAllowNullValue;
            liveData.isAutoClear = this.isAutoClear;
            liveData.noObserverCallback = this.noObserverCallback;
            liveData.throwNullEventException = this.throwNullEventException;
            return liveData;
        }
    }
}