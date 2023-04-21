val l = listOf(3,7,12,15,30)            // l: List<Int>
println(l)                              // [3, 7, 12, 15, 30]
println(l.toString())                   // [3, 7, 12, 15, 30]
val lc = listOf('a','4','#','x')        // lc: List<Char>
lc                                      // [a, 4, #, x]
l + 32      // [3, 7, 12, 15, 30, 32]
l - 12      // [3, 7, 12, 15, 30, 32]
l - 45      // [3, 7, 12, 15, 30]
10 in l     // false
15 in l     // true
l.size      // 5
(l + 34).size       // 6
l + listOf(34, 5)   // [3, 7, 12, 15, 30, 34, 5]
l[3]                // 15
l.first()           // 3
l.last()            // 30
l[l.size-1]         // 30
val x = l + lc      // x: List<Any>  ???
val l2 = List(10){ i -> i+1 }   // l2: List<Int> [1,2,3,4,5,6,7,8,9,10]
List(5){ (1..10).random() }     // ex: [3, 8, 10, 6, 7]
List(5){ (1..10).random() }     // ex: [7, 9, 3, 4, 9]
List(10){ (1..10).random() }    // ex: [9, 3, 7, 2, 8, 10, 3, 7, 1, 5]
List(10){ i -> i+1 }.shuffled() // ex: [4, 6, 9, 1, 2, 8, 10, 3, 7, 5] (no reps)
l.random()                  // ex: 12
l.filter{ e -> e%3==0 }     // [3, 12, 15, 30]
l.filter { it > 12 }        // [15, 30]
l.map{ it/10 }              // [0, 0, 1, 1, 3]
lc.map{ it.code }           // [97, 52, 35, 120]
l.sum()                     // 67
l.forEach { print("$it ")  }    // 3 7 12 15 30
var res=0
l.forEach { res += it }
res                         // 67