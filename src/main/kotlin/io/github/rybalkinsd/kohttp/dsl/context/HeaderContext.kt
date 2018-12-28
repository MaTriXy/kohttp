package io.github.rybalkinsd.kohttp.dsl.context

@HttpDslMarker
class HeaderContext {
    private val map: MutableMap<String, Any> = mutableMapOf()

    infix fun String.to(v: Any) {
        map[this] = v
    }

    fun cookie(init: CookieContext.() -> Unit) {
        map["cookie"] = CookieContext().also(init).collect()
    }

    internal fun forEach(action: (k: String, v: Any) -> Unit) = map.forEach(action)
}