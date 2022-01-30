package com.example.usersgetapi.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersgetapi.model.network.models.User
import com.example.usersgetapi.databinding.ItemUserBinding

class UserAdapter(
    private val userList: List<User>
): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(private val binding: ItemUserBinding):
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
                with(binding){
                    nameTv.text = "${user.id}: ${user.name}"
                    emailTv.text = user.email
                    usernameTv.text = user.username
                    addressTv.text = "${user.address.street} ${user.address.suite} ${user.address.city} ${user.address.zipcode} ${user.address.geo.lat} ${user.address.geo.lng}"
                    phoneTv.text = user.phone
                    companyTv.text = "${user.company.name} ${user.company.catchPhrase} ${user.company.bs}"
                    websiteTv.text = user.website
                }
            }
        }
    }