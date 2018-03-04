//package com.dev.apay.application
//
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import com.dev.apay.R
//import kotlinx.android.synthetic.main.single_offer.view.*
//
///**
// * Created by user on 2/13/2018.
// */
//
//class OffersFragment : Fragment() {
//
//    companion object {
//
//        val sliderArray= arrayOf(R.drawable.account_menu,R.drawable.help_icon,R.drawable.log_out_icon,
//                R.drawable.merchants_icon,R.drawable.settings_icon,R.drawable.share_icon,R.drawable.ic_action_name,
//                R.drawable.tutorials_icon)
//
//        fun newInstance(position: Int): OffersFragment {
//
//            val args = Bundle()
//            args.putInt("KEY", position)
//            val fragment = OffersFragment()
//            fragment.arguments = args
//            return fragment
//        }
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view=inflater.inflate(R.layout.single_offer,container,false)
//        var imageView=view.findViewById(R.id.single_offer) as ImageView
//        imageView.setImageResource(sliderArray[arguments!!.getInt("KEY")])
//        return view
//    }
//}
