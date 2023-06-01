fun main() {
    val lst = List(100){ (0..99).random()}.sorted()
    println("List: $lst")
    println(binSearch(lst, 50))
}

/**
 * Binary search function.
 * Returns index of [value] in [sorted] list or null if not found.
 * @param sorted Sorted list of integers where to search
 * @param value Value to search
 * @param start Start index of search in sorted list (default 0)
 * @param end End index of search in sorted list (default last index of sorted list)
 * @return Index of value in sorted list or null if not found.
 */
fun binSearch(sorted: List<Int>, value: Int, start: Int = 0, end: Int = sorted.lastIndex): Int? {
    if (end<start) return null
    val mid = (start+end)/2
    return when {
        value == sorted[mid] -> mid
        value < sorted[mid] -> binSearch(sorted,value,start,mid-1)
        else -> binSearch(sorted,value,mid+1,end)
    }
}
