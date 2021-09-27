package entities

import Game
import Scenes.SpaceScene
import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.view.Sprite
import com.soywiz.korge.view.hitShape
import com.soywiz.korma.geom.vector.circle

@KorgeInternal
class Cloud(val spaceScene: SpaceScene, val game: Game) : Image() {
    val cloud: Sprite = game.resources.cloud1

    init {
        name = "cloud"
        anchor(0.5, 0.5)
        hitShape { circle(100, 100, 10) }
        scale(0.5)
    }
}
