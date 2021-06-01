package study.problem.kt

import java.util.*

class Solution {
    private var nameSpace = mutableMapOf<String, String>()

    fun solution(record: Array<String>): Array<String> {
        val records = mutableListOf<Record>()
        for (input in record) {
            val st = StringTokenizer(input)
            val event = st.nextToken();
            val id = st.nextToken();
            if (st.hasMoreTokens()) {
                val name = st.nextToken();
                nameSpace[id] = name;
            }
            records.add(Record(id, Event.getEvent(event)))
        }
        return records
            .filter { it.event != Event.CHANGE }
            .map { "${nameSpace[it.id]}님이 ${it.event}" }
            .toTypedArray()
    }

    class Record(val id: String, val event: Event)

    enum class Event {
        ENTER,
        LEAVE,
        CHANGE;

        override fun toString(): String {
            return when (this) {
                ENTER -> "들어왔습니다."
                LEAVE -> "나갔습니다."
                else -> ""
            }
        }

        companion object {
            fun getEvent(name: String): Event {
                for (e in values()) {
                    if (e.name.equals(name, ignoreCase = true)) {
                        return e
                    }
                }
                throw IllegalArgumentException("not matching Event")
            }
        }
    }
}