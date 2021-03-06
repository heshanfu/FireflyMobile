package xyz.hisname.fireflyiii.repository.models.transaction

import com.google.gson.annotations.SerializedName

data class Errors(
        @SerializedName("transactions.0.destination_name")
        val transactions_destination_name: List<String>?,
        @SerializedName("transactions.0.currency_code")
        val transactions_currency: List<String>?,
        @SerializedName("transactions.0.source_name")
        val transactions_source_name: List<String>?,
        val bill_name: List<String>?,
        val piggy_bank_name: List<String>?
)