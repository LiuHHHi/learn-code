Java与Oracle、PostgresSQL数据类型对应



| Java    | Oracle                      | PostgresSQL | MySQL              |
| ------- | --------------------------- | ----------- | ------------------ |
| Boolean | number(1)                   | boolean     | boolean            |
| Byte    | number(2)                   |             |                    |
| Short   | number(3)~number(4)         | int2        |                    |
| Integer | number(5)~number(9)         | int4        | integer            |
| Long    | number(10)~number(18)       | int8        | integer            |
| Float   | number(m,n)m:长度n:小数位数 | float4      | float              |
| Double  | number(m,n)m:长度n:小数位数 | float8      | double             |
| String  | varchar2                    | varchar     | text               |
| Date    | timestamp                   | timestamp   | datetime/timestamp |
| Byte[]  | blob ：二进制存储           |             | blob               |
| String  | clob：大文本存储            | text        | longtext           |