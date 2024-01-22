package com.alex.dashboarddemo.data.mockdata

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.presentation.common.model.GSDAAnimal

class GSDAAnimalListProvider : PreviewParameterProvider<List<GSDAAnimal>> {
    override val values = sequenceOf(
        listOf(
            GSDAAnimal("Jaguar", R.drawable.jaguar),
            GSDAAnimal("Scarlet Macaw", R.drawable.scarlet_macaw),
            GSDAAnimal("Baby Green Sea Turtle", R.drawable.baby_green_sea_turtle),
            GSDAAnimal("Red-Eyed Tree Frog", R.drawable.red_eyed_tree_frog),
            GSDAAnimal("Hoffman's Two-Toed Sloth", R.drawable.hoffmans_two_toed_sloth),
            GSDAAnimal("Resplendent Quetzal", R.drawable.resplendent_quetzal),
            GSDAAnimal("White-Nosed Coati", R.drawable.white_nosed_coati),
            GSDAAnimal("Green Iguana", R.drawable.greeen_iguana),
            GSDAAnimal("Keel-Billed Toucan", R.drawable.keel_billed_toucan),
            GSDAAnimal("Capuchin Monkey", R.drawable.capuchin_monkey),
            GSDAAnimal("Emerald Basilisk", R.drawable.emerald_basilisk),
            GSDAAnimal("King Vulture", R.drawable.king_vulture),
        ),
    )
}
