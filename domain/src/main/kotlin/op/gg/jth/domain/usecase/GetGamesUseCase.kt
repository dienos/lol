package op.gg.jth.domain.usecase

import kotlinx.coroutines.*
import op.gg.jth.domain.model.remote.GamesResponseRepo
import op.gg.jth.domain.repository.remote.GamesRepository
import java.lang.Exception

class GetGamesUseCase(private val repository: GamesRepository) {
    operator fun invoke(
        lastMatch: Int,
        scope: CoroutineScope,
        onResult: (GamesResponseRepo) -> Unit = {},
        onFail: (String) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            try {
                val deferredList: ArrayList<Deferred<GamesResponseRepo>> = arrayListOf()

                deferredList.add(async {
                    repository.getGames(
                        lastMatch
                    )
                })

                onResult(deferredList.awaitAll()[0])
            } catch (e: Exception) {
                e.message?.let {
                    onFail(it)
                } ?: onFail("알수 없는 에러 입니다.")
            }
        }
    }
}