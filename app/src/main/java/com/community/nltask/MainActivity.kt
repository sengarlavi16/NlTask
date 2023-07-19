package com.community.nltask

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.community.nltask.api.models.City
import com.community.nltask.api.models.Countries
import com.community.nltask.api.models.Pincode
import com.community.nltask.api.models.States
import com.community.nltask.api.presenter.HomePresenter
import com.community.nltask.api.views.IMainView
import com.community.nltask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IMainView {

    private lateinit var context: Context

    lateinit var binding: ActivityMainBinding
    lateinit var countryadapter: ArrayAdapter<String>
    lateinit var stateadapter: ArrayAdapter<String>
    lateinit var cityadapter: ArrayAdapter<String>
    lateinit var pinadapter: ArrayAdapter<String>
    var countryId = ArrayList<String>()
    var stateId = ArrayList<String>()
    var cityid = ArrayList<String>()
    var pinid = ArrayList<String>()
    var stateList : ArrayList<States> = ArrayList()
    var cityList : ArrayList<City> = ArrayList()
    var pinList : ArrayList<Pincode> = ArrayList()
    private var selectedStateId: String = ""
    lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        context = applicationContext

        presenter = HomePresenter()
        presenter.view = this

        countryadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryId)
        binding.CountrySpinner.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.spin_drop_down_view)
            dialog.window?.setLayout(650, 800)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            val editText: EditText = dialog.findViewById(R.id.edit_text)
            val listView: ListView = dialog.findViewById(R.id.list_view)

            countryadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryId)
            listView.adapter = countryadapter
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    countryadapter.filter.filter(s)
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                if (position > 0) {
                    stateId.clear()
                    cityid.clear()
                    pinid.clear()
                    val selectedState = stateList[position]
                    selectedState.statebl?.get(position)?.name?.let { stateId.add(it) }
                    stateadapter.notifyDataSetChanged()
                } 
                binding.CountrySpinner.text = countryadapter.getItem(position)
                dialog.dismiss()
                presenter.state(context)
            }
        }

        presenter.country(context)

        stateadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stateId)
        binding.StateSpinner.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.spin_drop_down_view)
            dialog.window?.setLayout(650, 800)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            val editText: EditText = dialog.findViewById(R.id.edit_text)
            val listView: ListView = dialog.findViewById(R.id.list_view)

            stateadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stateId)
            listView.adapter = stateadapter
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    stateadapter.filter.filter(s)
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                binding.StateSpinner.text = stateadapter.getItem(position)
                dialog.dismiss()
            }
        }

        cityadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cityid)
        binding.CitySpinner.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.spin_drop_down_view)
            dialog.window?.setLayout(650, 800)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            val editText: EditText = dialog.findViewById(R.id.edit_text)
            val listView: ListView = dialog.findViewById(R.id.list_view)

            cityadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cityid)
            listView.adapter = cityadapter
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    cityadapter.filter.filter(s)
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                binding.CitySpinner.text = cityadapter.getItem(position)
                dialog.dismiss()
            }
        }

        pinadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pinid)
        binding.PincodeSpinner.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.spin_drop_down_view)
            dialog.window?.setLayout(650, 800)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            val editText: EditText = dialog.findViewById(R.id.edit_text)
            val listView: ListView = dialog.findViewById(R.id.list_view)

            pinadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pinid)
            listView.adapter = pinadapter
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    pinadapter.filter.filter(s)
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                binding.PincodeSpinner.text = pinadapter.getItem(position)
                dialog.dismiss()
            }
        }

    }

    override fun onCountrySuccess(item: Countries) {
        countryId.clear()
        stateId.clear()
        cityid.clear()
        pinid.clear()
        stateList.clear()
        cityList.clear()
        pinList.clear()
        for (i in 0 until (item.countriesbl?.size ?: 0)) {
            item.countriesbl?.get(i)?.name?.let { countryId.add(it) }
        }
        countryadapter.notifyDataSetChanged()
    }

    override fun onStateSuccess(item: States) {
        stateId.clear()
        cityid.clear()
        pinid.clear()
        stateList.clear()
        cityList.clear()
        pinList.clear()

        if (item.statebl?.isNotEmpty() == true) {
            for (i in item.statebl.indices) {
                item.statebl[i]?.name?.let { stateId.add(it)
                    }
            }

            stateadapter.notifyDataSetChanged()

            cityid.clear()
            cityList.clear()
            selectedStateId = item.statebl.get(0)?.id.toString()
            presenter.city(context, selectedStateId)
        }
    }

    override fun onCitySuccess(item: City) {
        cityid.clear()
        pinid.clear()
        cityList.clear()
        pinList.clear()

        if (item.citybl?.isNotEmpty() == true) {
            for (i in item.citybl.indices) {
                item.citybl[i]?.name?.let { cityid.add(it) }
            }

            cityadapter.notifyDataSetChanged()

            val selectedCityId = item.citybl.get(0)?.id
            presenter.pincode(context, selectedCityId.toString())
        }
    }

    override fun onPinSuccess(item: Pincode) {
        pinid.clear()
        pinList.clear()

        if (item.pincodeList?.isNotEmpty() == true) {
            for (i in item.pincodeList.indices) {
                item.pincodeList[i]?.pincode?.let { pinid.add(it) }
            }

            pinadapter.notifyDataSetChanged()
        }
    }

    override fun getContext(): Context {
        return context
    }

    override fun enableLoadingBar(context: Context, enable: Boolean, s: String) {

    }

    override fun onError(reason: String?) {
        Toast.makeText(context, reason, Toast.LENGTH_SHORT).show()
    }
}