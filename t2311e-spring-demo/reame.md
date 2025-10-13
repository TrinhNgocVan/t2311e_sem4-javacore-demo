1. Authentication và authorization 
 Authen : Ban la ai  ? , Author  : Ban dc lam gi ?
2. Phân loại author ntn  ???
 2.1. Role based Access Control: Bạn dc xem tin nhắn khi bạn có quyền READ_MESSAGE
 2.2. Access Control List : Sau khi kiểm tra bạn có quyền READ_MESSAGE -> bạn chỉ có quyền
     đọc tin nhắn với các tin nhắn mà bạn gửi đi , hoặc gửi đến bạn, hoặc trong nhóm có bạn là thành viên
 -> thường check logic trong cơ sở dữ liệu .
Các thiết kế service authen và author :
   + tích hợp authen và author trong service
   + tách user-service riêng thành 1 service , api gateway validate accessToken
   + sử dụng nền tảng IAM SERVICE (IAM - IDENTITY ACCESS MANAGEMENT) : keycloak or auth0
3. JWT : nhẹ , tự đóng gói 
   format : Authorization :  Bearer <JWT_Token> 
   cấu trúc : header.payload.signature 
  a. header : thuật toán mã hóa , kiểu token 
    "{ 'alg' : 'HS256', 'type' : 'JWT'}"
  b. payload : thông tin data của user , encoded base64 
  c. signature : xác thực jwt token có valid hay ko 
4. Expired : ko bao h để credential nào quá lâu  (thông thường chỉ nên để dưới 15 phút )
  -> refresh-token 





