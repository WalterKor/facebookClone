package com.koreait.facebook.facebookclone.user;

import com.koreait.facebook.facebookclone.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int join(UserEntity param);

}
