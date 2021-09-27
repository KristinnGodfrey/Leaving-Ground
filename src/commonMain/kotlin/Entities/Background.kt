package Entities

import Game
import Scenes.SpaceScene
import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.view.Image

@KorgeInternal
class Background(val spaceScene: SpaceScene, val game: Game) {
    val background: Image = game.resources.bgImage
    

}
