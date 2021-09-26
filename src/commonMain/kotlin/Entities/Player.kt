package entities

import Game
import com.soywiz.korev.Key
import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.Sprite
import com.soywiz.korge.view.addUpdater
import com.soywiz.korge.view.anchor
import com.soywiz.korge.view.hitShape
import com.soywiz.korma.geom.vector.circle

@KorgeInternal
class Player(val scene: Scene, val game: Game) : Sprite() {

    init {
        name = "player"
        anchor(0.5, 0.5)
        hitShape {
            circle(100, 100, 10)
        }

        addUpdater {
            val input = scene.stage.input
            if (input != null) {
                if (input.keys.pressing(Key.A)) {
                    x -= 5
                }
                if (input.keys.pressing(Key.D)) {
                    x += 5
                }
                if (input.keys.pressing(Key.W)) {
                    y -= 5
                }
                if (input.keys.pressing(Key.S)) {
                    y += 5
                }
            }
        }
//
        //                for (child in parent?.children!!) {
//                    println(child)
//                    if (collidesWithShape(child)) {
//                        solid.x = 300.0
//                        solid.y = 1000.0
////                        x = 0.0
////                        y = 0.0
//                    }
//                }
//
//                if (x < 0) {
//                    x = 0.0
//                }
//                if (y < 22) {
//                    y = 22.0
//                }
//
//                if (x + width >= 1280) {
//                    x = 1280 - width
//                }
//
//                if (y + height >= 768) {
//                    y = 768 - height
//                }
//}
//}
//}
    }
}
