// 2. Purely Functional Sets.

 object FunSets 
{
   /**
    * We represent a set by its characteristic function, i.e.
    * its `contains` predicate.
    */
   type Set = Int => Boolean
 
   /**
    * Indicates whether a set contains a given element.
    */
   def contains(s: Set, element: Int): Boolean = s(element)
 
  /**
    * Returns the set of the one given element.
    */

def singletonSet(elem: Int): Set = 
	{ 
		return x => (if (x==elem) 
				{true} 
			else 
				{false}); 
	}
 
   /**
    * Returns the union of the two given sets,
    * the sets of all elements that are in either `s` or `t`.
    */
 def union(s: Set, t: Set): Set = 
	{ 
		return a => (contains(s, a) || contains(t, a)); 
	}
 
   /**
    * Returns the intersection of the two given sets,
    * the set of all elements that are both in `s` and `t`.
    */
def intersect(s: Set, t: Set): Set = 
	{ 
		return a => (contains(s, a) && contains(t, a)); 
	}
 
   /**
    * Returns the difference of the two given sets,
    * the set of all elements of `s` that are not in `t`.
    */
def diff(s: Set, t: Set): Set = 
	{ 
		return a => (contains(s, a) && !contains(t, a)); 
	}
 
   /**
    * Returns the subset of `s` for which `p` holds.
    */
   def filter(s: Set, p: Int => Boolean): Set = 
	{ 
		return a => (contains(s, a) && p(a)); 
	}
 
   /**
    * The bounds for `forall` and `exists` are +/- 1000.
    */
  val bound = 1000

   /**
   * Returns whether all bounded integers within `s` satisfy `p`.
    */
  def forall(s: Set, p: Int => Boolean): Boolean = {
     def iterator(a: Int): Boolean = {
       if (a > bound) true 
      else if (contains(s, a) && !p(a)) false
      else iterator(a+1)
     }
    iterator(-bound)
   }
   
   /**
    * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
    */
   def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, a => !p(a))

   /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = a => exists(s, element => f(element) == a)
 
  /**
   * Displays the contents of a set
    */
   def toString(s: Set): String = 
	{
     		val xs = for (i <- -bound to bound if contains(s, i)) yield i
    		xs.mkString("{", ",", "}")
   	}
 
   /**
    * Prints the contents of a set on the console.
    */
   def printSet(s: Set) 
	{
     		println(toString(s))
  	}
 }