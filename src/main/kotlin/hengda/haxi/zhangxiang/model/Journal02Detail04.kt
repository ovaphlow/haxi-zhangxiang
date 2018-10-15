package hengda.haxi.zhangxiang.model

data class Journal02Detail04(
        var id: Int,
        var uuid: String,
        var master_id: Int,
        var subject: String,
        var software_version_new: String,
        var software_version_old: String,
        var approval_sn: String,
        var train: String,
        var date: String,
        var carriage: String,
        var time_begin: String,
        var time_end: String,
        var dept: String,
        var operator: String,
        var watcher: String,
        var watcher_group: String,
        var qc: String,
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