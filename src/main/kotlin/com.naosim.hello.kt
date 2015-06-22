package hello

import spark.Request
import spark.Response
import spark.Spark
import java.util.*

fun main(args: Array<String>) {
    Spark.get("kotlin", { request, response -> "kotlin" });
}

class Hoo() {
    fun route(request: Request?, response: Response?): String {
        val valid = Valid(request!!);
        return if(valid.verify("foo", Validator.notBlank).all()) "YES" else "NO";
    }
}

class Valid(val request: Request, val result: Boolean = true) {
    fun verify(key: String, valid: ((String) -> Boolean)): Valid {
        if(!result) return Valid(request, result);
        val newResult = Optional.ofNullable(request.queryParams(key)).filter(valid).isPresent();
        return Valid(request, newResult);
    }

    fun verify(key: String, validator: Validator): Valid = verify(key, validator.verify);

    fun all(): Boolean = result
}

enum class Validator(val verify: ((String) -> Boolean)) {
    notBlank({ it.isNotBlank() });
}