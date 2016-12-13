object Lab3 extends App{
  val R = FunSets
  val t1 = Set(1,2,3,4)
  val t2 = Set(3,6,15,8,10)
  R.printSet(R.union(R.singletonSet(1), R.singletonSet(3)))
  R.printSet(R.diff(t2, t1))
  println(R.forall(t2, _ > 1))
  R.printSet(R.map(t2, _ + 2))
}

object FunSets {
  /**
    * We represent a set by its characteristic function, i.e.
    * its `contains` predicate.
    */
  type Set = Int => Boolean

  /**
    * Indicates whether a set contains a given element.
    */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
    * Returns the set of the one given element.
    */
  def singletonSet(elem: Int): Set = {
    Set(elem)
  }

  /**
    * Returns the union of the two given sets,
    * the sets of all elements that are in either `s` or `t`.
    */
  def union(s: Set, t: Set): Set = i => s(i) || t(i)

  /**
    * Returns the intersection of the two given sets,
    * the set of all elements that are both in `s` and `t`.
    */
  def intersect(s: Set, t: Set): Set = i => s(i) && t(i)

  /**
    * Returns the difference of the two given sets,
    * the set of all elements of `s` that are not in `t`.
    */
  def diff(s: Set, t: Set): Set = i => s(i) && !t(i)

  /**
    * Returns the subset of `s` for which `p` holds.
    */
  def filter(s: Set, p: Int => Boolean): Set = i => p(i) && s(i)

  /**
    * The bounds for `forall` and `exists` are +/- 1000.
    */
  val bound = 1000

  /**
    * Returns whether all bounded integers within `s` satisfy `p`.
    */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    var f = true
    for(i <- -bound to bound) {
      if(s(i) && !p(i)) f = false
    }
    f
  }


  /**
    * Returns whether there exists a bounded integer within `s`
    * that satisfies `p`.
    */
  def exists(s: Set, p: Int => Boolean): Boolean = {
    var f = false
    for(i <- -bound to bound) {
      if(s(i) && p(i)) f = true
    }
    f
  }

  /**
    * Returns a set transformed by applying `f` to each element of `s`.
    */
  def map(s: Set, f: Int => Int): Set = {
    var r = diff(s, s)
    for(i <- -bound to bound) {
      if (s(i)) r = union(r, singletonSet(f(i)))
    }
    r
  }

  /**
    * Displays the contents of a set
    */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
    * Prints the contents of a set on the console.
    */
  def printSet(s: Set) {
    println(toString(s))
  }
}