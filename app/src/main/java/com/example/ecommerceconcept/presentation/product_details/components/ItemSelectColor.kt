package com.example.ecommerceconcept.presentation.product_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerceconcept.domain.model.detail.SelectColorPhoneModel

@Composable
fun ItemSelectedColorPhone(
    selectColorPhoneModel: SelectColorPhoneModel,
    clickColor: () -> Unit,
    image: Int? = null
) {
    Column(verticalArrangement = Arrangement.Center) {
        if (selectColorPhoneModel.color != null) {
            Card(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { (clickColor()) },
                elevation = 0.dp,
                backgroundColor = selectColorPhoneModel.color!!
            ) {
                if (image != null) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth(),
                        alignment = Alignment.Center
                    )
                }
            }
        }
    }
}