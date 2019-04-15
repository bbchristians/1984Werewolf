package dev.benchristians.a1984werewolf

enum class Role(val order: Int, val backgroundResource: Int, val mp3Res: Int) {
    BROTHERHOOD_MEMBER(-1, -1, -1),
    SCAPEGOAT(1, -1, R.raw.snaps),
    INVESTIGATOR(2, -1, R.raw.snaps),
    LEXICOGRAPHER(4, -1, R.raw.snaps),
    DOUBLETHINKER(3, -1, R.raw.snaps),
    THOUGHT_POLICE(5, -1, R.raw.snaps),
    UNPERSON(7, -1, R.raw.snaps),
    INTERROGATOR(-1, -1, R.raw.snaps),
    NEIGHBOR(6, -1, R.raw.snaps),
    SINGER(8, -1, R.raw.snaps),
    PROLE(-1, -1, R.raw.snaps)
}