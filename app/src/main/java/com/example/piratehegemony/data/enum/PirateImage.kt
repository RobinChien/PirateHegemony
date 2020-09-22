package com.example.piratehegemony.data.enum

import com.example.piratehegemony.R

enum class PirateImage(val pirateId: Int, val pirateImage: Int) {
    BULBASAUR(1, R.drawable.aoe_imperialskirmisher),
    IVYSAUR(2, R.drawable.aoe_petard),
    VENUSAUR(3, R.drawable.aoe_battle_elephant),
    CHARMANDER(4, R.drawable.aoe_arbalester),
    CHARMELEON(5, R.drawable.aoe_legionary),
    CHARIZARD(6, R.drawable.aoe_bombard_cannon),
    TORRENT(7, R.drawable.aoe_tarkan),
    WARTORTLE(8, R.drawable.aoe_camelrider),
    BLASTOISE(9, R.drawable.aoe_hand_cannoneer),
    CATERPIE(10, R.drawable.aoe_monk);

    companion object {
        fun getPirateImage(pirateId: Int): PirateImage {
            return when (pirateId) {
                1 -> BULBASAUR
                2 -> IVYSAUR
                3 -> VENUSAUR
                4 -> CHARMANDER
                5 -> CHARMELEON
                6 -> CHARIZARD
                7 -> TORRENT
                8 -> WARTORTLE
                9 -> BLASTOISE
                10 -> CATERPIE
                else -> BULBASAUR
            }
        }
    }
}