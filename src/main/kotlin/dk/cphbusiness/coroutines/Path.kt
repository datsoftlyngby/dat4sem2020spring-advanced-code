package dk.cphbusiness.coroutines

class Path<T>(val value: T, val rest: Path<T>? = null) : Iterable<T> {

  fun print() {
    println(value)
    rest?.print()
    }

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

  }


fun main() {
  val names = Path("Anders", Path("Bente", Path("Christine")))
  for (name in names) println(name)
  names.print()
  // print(names)
  }