package dev.benchristians.a1984werewolf

enum class Role(val order: Int, val backgroundResource: Int) {
    BROTHERHOOD_MEMBER(0, -1),
    SCAPEGOAT(1, -1),
    INVESTIGATOR(2, -1),
    LEXICOGRAPHER(4, -1),
    DOUBLETHINKER(3, -1),
    THOUGHT_POLICE(5, -1),
    UNPERSON(7, -1),
    INTERROGATOR(-1, -1),
    NEIGHBOR(6, -1),
    SINGER(8, -1),
    PROLE(-1, -1)
}