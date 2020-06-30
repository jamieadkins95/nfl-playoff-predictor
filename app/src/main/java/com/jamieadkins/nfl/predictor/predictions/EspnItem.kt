package com.jamieadkins.nfl.predictor.predictions

import com.jamieadkins.nfl.predictor.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

class EspnItem : Item() {

    override fun getLayout(): Int = R.layout.view_espn_attribution

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        // Do nothing
    }

    override fun isSameAs(other: com.xwray.groupie.Item<*>): Boolean = other is EspnItem

    override fun hasSameContentAs(other: com.xwray.groupie.Item<*>): Boolean = other is EspnItem
}