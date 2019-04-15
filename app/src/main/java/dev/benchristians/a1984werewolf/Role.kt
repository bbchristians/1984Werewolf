package dev.benchristians.a1984werewolf

enum class Role(val order: Int, val backgroundResource: Int, val introMP3: AudioQueue? = null, val outroMP3: AudioQueue? = null) {
    BROTHERHOOD_MEMBER(-1, -1),
    SCAPEGOAT(1, -1, AudioQueue(R.raw.orwell_scapegoat1, 6000L), AudioQueue(R.raw.orwell_scapegoat2, 1500L)),
    INVESTIGATOR(2, -1, AudioQueue(R.raw.orwell_investigator1, 6000L), AudioQueue(R.raw.orwell_investigator2, 1500L)),
    LEXICOGRAPHER(4, -1, AudioQueue(R.raw.orwell_lexicographer1, 4000L), AudioQueue(R.raw.orwell_lexicographer2, 1500L)),
    DOUBLETHINKER(3, -1, AudioQueue(R.raw.orwell_doublethinker1, 4000L),AudioQueue(R.raw.orwell_doublethinker2, 1500L)),
    THOUGHT_POLICE(5, -1, AudioQueue(R.raw.orwell_thoughtpolice1, 4000L), AudioQueue(R.raw.orwell_thoughtpolice2, 1500L)),
    UNPERSON(7, -1, AudioQueue(R.raw.orwell_unperson1, 3000L), AudioQueue(R.raw.orwell_unperson2, 1500L)),
    INTERROGATOR(-1, -1),
    NEIGHBOR(6, -1, AudioQueue(R.raw.orwell_neighbor1, 5000L), AudioQueue(R.raw.orwell_neighbor2, 1500L)),
    SINGER(8, -1, AudioQueue(R.raw.orwell_singer1, 2000L), AudioQueue(R.raw.orwell_singer2, 1000L)),
    PROLE(-1, -1)
}