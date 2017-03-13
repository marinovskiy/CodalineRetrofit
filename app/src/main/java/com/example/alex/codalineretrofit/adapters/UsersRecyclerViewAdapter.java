package com.example.alex.codalineretrofit.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alex.codalineretrofit.R;
import com.example.alex.codalineretrofit.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRecyclerViewAdapter
        extends RecyclerView.Adapter<UsersRecyclerViewAdapter.UserViewHolder> {

    private List<User> users = new ArrayList<>();

    public UsersRecyclerViewAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindUser(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivAvatar;
        private TextView tvLogin;

        public UserViewHolder(View itemView) {
            super(itemView);

            ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
            tvLogin = (TextView) itemView.findViewById(R.id.tv_login);
        }

        void bindUser(User user) {
            Glide.with(itemView.getContext())
                    .load(user.getAvatarUrl())
                    .into(ivAvatar);
            tvLogin.setText(user.getLogin());
        }
    }
}