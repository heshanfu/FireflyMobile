package xyz.hisname.fireflyiii.repository.models.transaction.sucess

data class Attributes(
        val updated_at: String,
        val created_at: String,
        val description: String,
        val transaction_description: Any,
        val date: String,
        val type: String,
        val identifier: Int,
        val journal_id: Int,
        val reconciled: Boolean,
        val amount: Int,
        val currency_id: Int,
        val currency_code: String,
        val currency_symbol: String,
        val currency_dp: Int,
        val foreign_amount: Any,
        val foreign_currency_id: Any,
        val foreign_currency_code: Any,
        val foreign_currency_symbol: Any,
        val foreign_currency_dp: Any,
        val bill_id: Any,
        val bill_name: Any,
        val category_id: Any,
        val category_name: Any,
        val budget_id: Any,
        val budget_name: Any,
        val notes: Any,
        val source_id: Int,
        val source_name: String,
        val source_iban: Any,
        val source_type: String,
        val destination_id: Int,
        val destination_name: String,
        val destination_iban: Any,
        val destination_type: String
)