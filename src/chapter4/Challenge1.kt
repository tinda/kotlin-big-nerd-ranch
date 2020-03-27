package chapter4

fun main() {
    val name = "Madrigal"
    var healthPoints = (1..100).shuffled().first()
    val isBlessed = listOf(true, false).shuffled().first()
    val isImmortal = false

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = auraColor(auraVisible)

    // Player status
    val healthStatus = when(healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has come minor wounds but is healing quite quickly!"
        } else {
            "has come minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    // Output
    val statusFormatString = "(HP)(A) -> H"
    println(statusFormatString
        .replace("(HP)", "(HP: $healthPoints)")
        .replace("A", "Aura: $auraColor")
        .replace(" -> H", " -> $name $healthStatus")
    )
}

private fun auraColor(auraVisible: Boolean): String  = if (auraVisible) "GREEN" else "NONE"
