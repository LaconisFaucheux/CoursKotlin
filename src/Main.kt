fun main() {

    //création de listes
    val list1 = listOf(10, 2, 5, 18, 9, 25, 3)
    val list2 = listOf(8, 7, 14, 30, 1, 4, 22, 50)

    //fusionner les listes pour avoir une liste  complète
    val mergedList = list1 + list2

    println("Liste fusionnée $mergedList")

    //tri de la liste
    val sortedList = mergedList.sorted()
    println("Liste triée: $sortedList")

    //test de la valeur recherchée par dichotomie et classique
    var targets = listOf(4, 12, 22)
    for(t in targets) {
        val targetIndex = binarySearch(sortedList, t)
        val compareIndex = dumbSearch(sortedList, t)
        if(targetIndex != -1){
            println("L'élément $t a été trouvé à l'index $targetIndex avec la recherche dichotomique.")
        } else {
            println("L'élément $t n'a  pas été trouvé.")
        }
    }
}

fun binarySearch(list: List<Int>, target: Int): Int {
    var low = 0
    var high = list.size - 1
    var counter = 0
    while (low <= high) {
        counter += 1
        val mid = (low + high) / 2
        val guess = list[mid]
        if(guess ==  target) {
            println("$counter tours de boucle pour trouver l'élément $target avec la recherche dichotomique.")
            return mid
        }
        if (guess > target) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}

fun dumbSearch(list: List<Int>, target: Int): Int {
    var counter = 0
    for (element in list) {
        if(element == target) {
            println("$counter tours de boucle pour trouver l'élément $target avec la recherche classique.")
            return counter
        }
        counter += 1
    }
    return -1
}