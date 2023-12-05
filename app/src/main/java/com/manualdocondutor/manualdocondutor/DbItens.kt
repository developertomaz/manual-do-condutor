package com.manualdocondutor.manualdocondutor

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class DbItens(
    val id :Int,
    @DrawableRes val drawableId:Int,
    @StringRes val textStringId:Int,
    val color: Int
)
