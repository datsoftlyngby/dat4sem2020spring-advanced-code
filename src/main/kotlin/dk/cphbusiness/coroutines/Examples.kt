package dk.cphbusiness.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main_example_1() {
  GlobalScope.launch {
    delay(1000)
    println(" World!")
    }
  print("Hello")
  // thread { sleep(2000) }
  runBlocking { delay(2000) }
  }

fun main() = runBlocking {
  launch {
    delay(1000)
    println(" World!")
    }
  print("Hello")
  }