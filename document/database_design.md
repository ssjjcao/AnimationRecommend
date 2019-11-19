## _Animation Recommend Database Design_
### _version 8.0_

### _Table Name_
  * [_User_](#User)
  * [_Animation_](#Animation)
  * [_Type_](#Type)
  * [_Animation_Type_](#Animation_Type)
  * [_User_Type_](#User_Type)
  * [_Attitude_](#Attitude)
  * [_Comment_](#Comment)
 
### <span id="User">_user_</span>

| 字段名 | 字段意义 | 类型 | 补充说明 |
|:----:|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| name | 用户名 | String | name可以唯一映射一个用户，不允许出现重复用户名 |
| password | 密码 | String |
| signature | 个性签名 | String |
| create_tiime | 创建时间 | timestamp | 方便数据库维护 |
| update_time | 更新时间 | timestamp | 方便数据库维护 |

### <span id="Animation">_Animation_</span>

| 字段名 | 字段意义 | 类型 | 补充说明 |
|:----:|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| name| 番剧名 | String | name可以唯一映射一部番剧，不允许出现重复番剧名 |
| recommendation | 推荐语 | String |
| cover |封面图 | String |
| detail| 详情 | String |
| link | 观看链接 | String |
| page_view| 浏览量 | Integer |
| like_num | 点赞数 | Integer |
| unlike_num | 点踩数 | Integer |
| referrer_id | 推荐人 | Integer |
| create_tiime | 创建时间 | timestamp | 方便数据库维护 |
| update_time | 更新时间 | timestamp | 方便数据库维护 |

### <span id="Type">_Type_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| name | 番剧类型 | String |
| create_tiime | 创建时间 | timestamp |
| update_time | 更新时间 | timestamp |

### <span id="Animation_Type">_Animation_Type_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| animation_id | 番剧id | Integer |
| type_id | 番剧类型id | Integer |
| create_tiime | 创建时间 | timestamp |
| update_time | 更新时间 | timestamp |

### <span id="User_Type">_User_Type_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| user_id | 用户id | Integer |
| type_id | 番剧类型id | Integer |
| create_tiime | 创建时间 | timestamp |
| update_time | 更新时间 | timestamp |

### <span id="Attitude">_Attitude_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| user_id | 用户id | Integer |
| animation_id | 番剧id | Integer |
| favorite | true or false or null 表示是否喜欢 | Boolean |
| create_tiime | 创建时间 | timestamp |
| update_time | 更新时间 | timestamp |

### <span id="Comment">_Comment_</span>

| 字段名 | 字段意义 | 类型 |
|:----:|:----:|:----:|
| id | 伪主键 | Integer |
| user_id | 用户id | Integer |
| animation_id | 番剧id | Integer |
| comment | 评论 | String |
| create_tiime | 创建时间 | timestamp |
| update_time | 更新时间 | timestamp |
