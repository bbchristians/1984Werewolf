package dev.benchristians.a1984werewolf

enum class Role(val order: Int, val portrait: Int, val introMP3: AudioQueue? = null, val outroMP3: AudioQueue? = null) {
    BROTHERHOOD_MEMBER_1(-1, R.drawable.portrait_1984_winston),
    BROTHERHOOD_MEMBER_2(-1, R.drawable.portrait_1984_julia),
    SCAPEGOAT(1, R.drawable.portrait_1984_goldstein, AudioQueue(R.raw.orwell_scapegoat1, 6000L), AudioQueue(R.raw.orwell_scapegoat2, 1500L)),
    INVESTIGATOR(2, R.drawable.portrait_1984_charrington, AudioQueue(R.raw.orwell_investigator1, 6000L), AudioQueue(R.raw.orwell_investigator2, 1500L)),
    LEXICOGRAPHER(4, R.drawable.portrait_1984_syme, AudioQueue(R.raw.orwell_lexicographer1, 4000L), AudioQueue(R.raw.orwell_lexicographer2, 1500L)),
    DOUBLETHINKER(3, R.drawable.portrait_1984_doublethinker, AudioQueue(R.raw.orwell_doublethinker1, 4000L),AudioQueue(R.raw.orwell_doublethinker2, 1500L)),
    THOUGHT_POLICE(5, R.drawable.portrait_1984_thought_police, AudioQueue(R.raw.orwell_thoughtpolice1, 4000L), AudioQueue(R.raw.orwell_thoughtpolice2, 1500L)),
    UNPERSON(7, R.drawable.portrait_1984_unperson, AudioQueue(R.raw.orwell_unperson1, 3000L), AudioQueue(R.raw.orwell_unperson2, 1500L)),
    INTERROGATOR(-1, R.drawable.portrait_1984_obrien),
    NEIGHBOR_1(6, R.drawable.portrait_1984_mrs_parsons, AudioQueue(R.raw.orwell_neighbor1, 5000L), AudioQueue(R.raw.orwell_neighbor2, 1500L)),
    NEIGHBOR_2(-1, R.drawable.portrait_1984_tom_parsons),
    SINGER(8, R.drawable.portrait_1984_singing_woman, AudioQueue(R.raw.orwell_singer1, 2000L), AudioQueue(R.raw.orwell_singer2, 1000L)),
    PROLE(-1, R.drawable.portrait_1984_prole)
}