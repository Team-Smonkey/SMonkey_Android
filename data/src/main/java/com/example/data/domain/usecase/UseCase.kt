package com.example.data.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, E>(private val disposable : CompositeDisposable) {

    abstract fun buildUseCase(data : T) : Single<E>

    fun execute(data: T, singleObserver: DisposableSingleObserver<E>, scheduler: Scheduler) {
        val observer = buildUseCase(data)
            .subscribeOn(Schedulers.io())
            .observeOn(scheduler)
            .subscribeWith(singleObserver)

        disposable.add(observer)
    }
}