package hengda.haxi.zhangxiang.model

data class Journal02Detail01(
        var master_id: Int,
        var subject: String,
        var approval_sn: String,
        var train_sn: String,
        var date: String,
        var carriage: String,
        var carriage_subject: String,
        var time_begin: String,
        var time_end: String,
        var result: String,
        var report: String,
        var dept: String,
        var executor: String,
        var remark: String,
        var carriage_01: Boolean,
        var carriage_02: Boolean,
        var carriage_03: Boolean,
        var carriage_04: Boolean,
        var carriage_05: Boolean,
        var carriage_06: Boolean,
        var carriage_07: Boolean,
        var carriage_08: Boolean
)
