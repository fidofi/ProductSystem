# ProductSystem
简易在线商城

采用的是jsp+servlet+mysql+jdbc的开发模式，并采用了maven做为项目管理

系统分为前台和后端
后端的管理员功能有对商品的增删改查，用户冻结，查看用户资料，查看商品销售情况的图表的功能，在对列表展示的时候使用了分页，有商品图片上传和查看，
并利用了cookie技术记录了管理员上次登陆的时间。支持关键词查询，模糊查询，价格区间查询等查询功能。

前台为客户端，游客可查看商城的商品，包括新品，特价品和其他商品，用户也可通过关键词查询，模糊查询，价格区间查询等查询具体的商品，
登录的用户可将商品添加至购物车，并在此过程对库存做了检测。
