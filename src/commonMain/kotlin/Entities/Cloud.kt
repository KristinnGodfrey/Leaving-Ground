package entities

import Game
import Scenes.SpaceScene
import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.view.Image

@KorgeInternal
class Cloud(val spaceScene: SpaceScene, val game: Game) {
    val cloud1: Image = game.resources.cloud1
}
