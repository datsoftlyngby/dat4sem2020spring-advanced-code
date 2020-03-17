package dk.cphbusiness.coroutines

sealed class Path<T> : Iterable<T> {
  class ValuePath<T>(val value: T, val rest: Path<T>) : Path<T>() {
    override fun iterator(): Iterator<T>  = iterator {
      yield(value)
      yieldAll(rest)
      }
    }
  class EmptyPath<T> : Path<T>() {
    override fun iterator(): Iterator<T> = iterator { }
    }
  }

fun main() {
  val names = Path.ValuePath("Anders", Path.ValuePath("Bente", Path.ValuePath("Christine", Path.EmptyPath())))
  for (name in names) println(name)
  }



/*
class Path<T>(val value: T, val rest: Path<T>? = null) : Iterable<T> {

  fun print() {
    println(value)
    rest?.print()
    }


  override fun iterator(): Iterator<T> = iterator {
    yield(value)
    if (rest != null) yieldAll(rest!!)
    }

  /*
  override fun iterator(): Iterator<T> {
    return PathIterator(this)
    }

  class PathIterator<T>(var step: Path<T>?) : Iterator<T> {

    override fun hasNext(): Boolean {
      return step != null
      }

    override fun next(): T {
      val result = step!!.value // Brug ikke uden en voksen
      // val result = step?.value
      step = step?.rest
      return result
      }

    }
   */

  }


fun main() {
  val names = Path("Anders", Path("Bente", Path("Christine")))
  for (name in names) println(name)
  names.print()
  // print(names)
  }

 */