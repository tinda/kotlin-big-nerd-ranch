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
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Player drunk status
    val drunkStatus = formatDrunkStatus(castFireball(5))

    // Output
    val statusFormatString = "(HP)(A) -> H -> D "
    println(
        statusFormatString
            .replace("(HP)", "(HP: $healthPoints)")
            .replace("A", "Aura: $auraColor")
            .replace(" -> H", " -> $name $healthStatus")
            .replace(" -> D", " -> $name $drunkStatus")
    )
}

private fun auraColor(auraVisible: Boolean): String = if (auraVisible) "GREEN" else "NONE"

private fun castFireball(
    numFireballs: Int = 2
): Int {
    println("A glass of Fireball springs into existence.")
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    return (1..50).random()
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
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
    return healthStatus
}

private fun formatDrunkStatus(drunkPoints: Int): String {
    val drunkStatus = when (drunkPoints) {
        in 1..10 -> "tipsy"
        in 11..20 -> "sloshed"
        in 20..30 -> "soused"
        in 31..40 -> "stewed"
        in 41..50 -> "..t0aSt3d"
        else -> "is in awful condition!"
    }
    return drunkStatus
}