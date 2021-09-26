import Scenes.SpaceScene
import Scenes.SpaceSceneDependency
import com.soywiz.korge.Korge
import com.soywiz.korge.scene.Module
import com.soywiz.korge.view.views
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korma.geom.SizeInt


object GameModule : Module() {
    val game = Game()
    override val title: String = "Leaving Ground 1: Escape From Space Base"
    override val mainScene = SpaceScene::class
    override val size: SizeInt = SizeInt(3325, 1970)

    override suspend fun AsyncInjector.configure(): Unit {
        game.views = views()
//        mapInstance(game)
        mapInstance(SpaceSceneDependency("Inject to SpaceScene"))
        mapPrototype { SpaceScene(get()) }
    }
}

suspend fun main() = Korge(Korge.Config(module = GameModule))
