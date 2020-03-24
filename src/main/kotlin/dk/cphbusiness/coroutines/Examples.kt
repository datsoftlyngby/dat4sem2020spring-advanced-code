package dk.cphbusiness.coroutines

import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main_example_1() {
  GlobalScope.launch {
    delay(1000)
    println(" World!")
    }
  print("Hello")
  // thread { sleep(2000) }
  runBlocking { delay(2000) }
  }

fun main_example_2() = runBlocking {
  launch {
    delay(1000)
    println(" World!")
    }
  print("Hello")
  }

fun main_example_3() {
  val result: Deferred<String> = GlobalScope.async {
    delay(1000)
    "World"
    }
  runBlocking {
    val who = result.await()
    println("Hello $who")
    }
  }

fun main_example_4() = runBlocking {
  val result = async { delay(1000); "World!" }
  println("Hello ${result.await()}")
  }

fun run_threads(max: Int) {
  for (index in 0..max) {
    thread {
      sleep(100)
      if (index%(max/10) == 0) println("running thread $index")
      }
    }
  }

fun run_coroutines(max: Int) = runBlocking {
  for (index in 0..max) {
    launch {
      delay(100)
      if (index%(max/10) == 0) println("running coroutine $index")
      }
    }
  }

fun main() {
  val count = 1_000_000
  val mc = measureTimeMillis {
    run_coroutines(count)
    }
  println("Coroutines: $mc")
  val mt = measureTimeMillis {
    run_threads(count)
    }
  println("Threads: $mt")
  }