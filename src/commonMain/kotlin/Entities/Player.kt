package entities

import Game
import Scenes.SpaceScene
import com.soywiz.korev.Key
import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.view.*
import com.soywiz.korma.geom.vector.circle

@KorgeInternal
class Player(val spaceScene: SpaceScene, val game: Game) : Sprite() {
    val playerIdle: SpriteAnimation = game.resources.playerIdleAnimation
    val playerRunning: SpriteAnimation = game.resources.playerRunningAnimation

    init {
        name = "player"
        anchor(0.5, 0.5)
        hitShape { circle(100, 100, 10) }
        scale(0.5)
        playAnimationLooped(game.resources.playerIdleAnimation)

        // TODO: rotation = 180.0.degrees not working
        addUpdater {
            val input = game.views.input
//            println(input)
            val a = input.keys.pressing(Key.A)
            val d = input.keys.pressing(Key.D)
            val w = input.keys.pressing(Key.W)
            val s = input.keys.pressing(Key.S)

//            println(a)
//            println(d)
//            println(w)
//            println(s)
            if (!a or !d or !w or !s) {
                playAnimation(game.resources.playerIdleAnimation)
            }
            if (a) {
                x -= 5
                playAnimationLooped(game.resources.playerRunningAnimation)
//                    rotation = 180.0.degrees
            }
            if (d) {
                x += 5
                playAnimationLooped(game.resources.playerRunningAnimation)
            }
            if (w) {
                y -= 5
                playAnimationLooped(game.resources.playerRunningAnimation)
            }
            if (s) {
                y += 5
                playAnimationLooped(game.resources.playerRunningAnimation)
            }


//            playAnimationLooped(game.resources.playerIdleAnimation)


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
