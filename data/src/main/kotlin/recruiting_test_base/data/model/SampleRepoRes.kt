package recruiting_test_base.data.model

import recruiting_test_base.domain.model.SampleRepo

data class SampleRepoRes(private val _name : String) : SampleRepo {
    override val name: String
        get() = _name
}