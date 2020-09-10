# Java Web Component

Tất cả các bài tập trong môn học này đều lấy ý tưởng về tạo dựng một hệ thống quản lý trường học cơ bản.

Hệ thống này chúng ta gọi là JUNIOR. JUNIOR sẻ là một hệ thống cho phép chúng ta quản lý các đối tượng tham gia như học sinh, giáo viên, quản trị hệ thống.

Các bạn hãy mường tượng về trường học các bạn từng học ví dụ như trường cấp 2. Ở đấy các bạn sẻ thấy có giáo viên, có học sinh, có các môn học, các tiết học,
có các bài kiểm tra, chấm điểm, các bài thi, những đánh giá học sinh, đánh giá tốt nghiệp. Nhiệm vụ của hệ thống này chúng ta cần tạo dựng lại toàn bộ những
chức năng tương ứng như thế để giáo viên, học sinh và những người liên quan có thể sử dụng được cho mục đích quản lí.

## Bài tập 1

Trong bài tập này các bạn sẻ tập làm quen với Java Servlet và JSP page.

Mục đích của bài tập này các bạn cần tạo một page tên là (course.jsp).

Chức năng của page này có phép nó hiển thị một danh sách các khóa học hiện tại của một trường. Chúng ta hãy cứ ví dụ đơn giản là một khóa học tại trường học
như là các bạn học sinh được học môn Toán, và môn Toán đó do một giáo viên cụ thể đảm nhiệm. Như vậy chúng ta gọi một course sẻ là một môn học mà có giáo viên
cụ thể nào đó đảm nhiệm. Lúc đó môn toán do thầy A đảm nhiệm là một course, và môn Toán do thầy B đảm nhiệm sẻ là một course khác.

Một course chứa các thông tin đơn giản như là (title) ví dụ như: Toán, Văn, Hóa ... (description) nội dung môn học mà các bạn học sinh sẻ được học, (open_date)
ngày mà môn này bắt đầu học buổi đầu tiên (close_date) ngày mà môn này kết thúc., (number_of_member) tổng số học sinh tham gia course này, (teacher_name) tên
của giáo viên đứng lớp cho course này. (editable) một course được coi là có thể chỉnh sửa nếu như ngày hiện tại nằm giữa (open_date) và (close_date).

Các bạn create một Java Servlet tên là (CourseServlet.java) chứa tính năng quyết định danh sách các course sẻ được hiện thị. Cho ví dụ này, các bạn chỉ cần tạo một
mãng danh sách hiển thị mẫu cho các course.

(course.jsp) sẻ nhận dữ liệu từ (CourseServlet.java) để hiện thị danh sách course.

## Bài tập 2

Trong bài tập này các bạn sẻ tập luyện cách sử dụng Servlet để chuyển trang

Trên màn hình hiện thị danh sách các courses (course.jsp) chúng ta đã làm từ bài tập trước. Chúng ta sẻ tạo ra một đường dẫn tên là (Manage), mục đích của đường dẫn
này sẻ giúp giáo viên có thể quản lý được course mà họ được phân công giảng dạy. Như vậy khi giáo viên click vào đường dẫn này, hệ thống sẻ chuyển sang trang
(course_detail.jsp)

Trong trang (course_detail.jsp), chúng ta sẻ hiển thị lại thông tin của course này kèm theo một danh sách các học sinh đang theo học course đấy. Mục đích của việc
hiển thị danh sách học sinh là để giáo viên có thể thực hiện điểm danh, chấm điểm, hay tương tác với từng học sinh một.

Để thực hiện được yêu cầu của bài tập này, chúng ta cần tạo ra một servlet khác tên là (CourseDetailServlet.java) mục đích của servlet này giúp chúng ta có thể
truy vấn thông tin của course, và danh sách các học sinh đang theo học course này.

## Bài tập 3

Trong bài tập này trước hết chúng ta cần chuyển đổi toàn bộ những jsp của bài tập trước (course.jsp, course_detai.jsp) sang sử dụng JSTL.

Sau đấy, chúng ta tiếp tục bổ sung thêm tính năng cho hệ thống JUNIOR như sau. Một course bình thường diễn ra sẻ có các bài kiểm tra, ví dụ kiểm tra miệng, kiểm tra
15', kiểm tra 1 tiết. Chúng ta cần xây dựng tính năng tương tự cho hệ thống JUNIOR mục đích để thầy cô có thể chấm điểm học sinh. Như vậy trong
trang (course_detail.jsp) chúng ta cần tạo một liên kết để dẫn tới trang châm điểm (course_grade.jsp). Chúng ta ngầm hiểu rằng với mỗi môn học sẻ luôn luôn có 2 
kiểm tra theo sau: kiểm tra miệng, kiểm tra 15', kiểm trang 1 tiết, đối với một học sinh trong khóa học.

Trang (course_grade.jsp) sẻ hiện thị một danh sách các cột là (1st On Board, 2st On Board, 1st Quick Test, 2st Quick Test, 1st Main Test, 2st Main Test, GPA), và các 
hàng tương ứng với mỗi học sinh tham gia khóa học và điểm số tương ứng của học sinh đó. Để thuận tiện cho việc chấm điểm học sinh, cuối mỗi hàng chúng ta cần
thêm vào một đường dẫn tới trang (course_mark.jsp). Trang (course_mark.jsp) sẻ cho phép giáo viên cho điểm cho học sinh đấy.

# Bài tập 4

Trong bài tập này, chúng ta sẻ làm quen với việc sử dụng datasource để tương tác với database

Trước tiên, chúng ta cần chuyển tất cả những dữ liệu của những bài tập trước sang cấu trúc dữ liệu để lưu trử trong cơ sở dữ liệu (CSDL - Database) như sau.

(tb_course)
- (id): định danh của (tb_course) dưới dạng số tự tăng.
- (title): tên môn học
- (description): mô tả chi tiết môn học (dưới dạng HTML) để display trên trang web.
- (open_date): ngày bắt đầu môn học
- (close_date): ngày kết thúc môn học
- (teacher_id): khóa ngoại định danh của giáo viên trong bảng (tb_user)

(tb_user)
- (id): định danh của (tb_user) dưới dạng số tự tăng.
- (email): email của user

(tb_course_users) - định danh của bảng này sẻ là một cặp (course_id, student_id)
- (course_id): khóa ngoại định danh của course trong bảng (tb_course)
- (student_id): khóa ngoại định danh của student trong bảng (tb_user)
- (on_board_1): điểm kiểm tra miệng lần 1
- (on_board_2): điểm kiểm tra miệng lần 2
- (quick_test_1): điểm kiểm tra 15' lần 1
- (quick_test_2): điểm kiểm tra 15' lần 2
- (main_test_1): điểm kiểm tra 1 tiết lần 1
- (main_test_2): điểm kiểm tra 1 tiết lần 2
- (note): ghi chú của giáo viên về học sinh trong môn học này

Trang (course_mark.jsp) sẻ được tinh chỉnh để giáo viên có thể cho điểm và ghi chú về học sinh.

Các công thức liên quan để tính toán hiển thị:

- tổng số học sinh tham gia một course được tính thông qua bảng (tb_course_users)
- một course còn có thể được editable nếu như ngày hiện tại của hệ thống nằm giữa ngày (open_date) và (close_date)
- điểm GPA của một môn học được tính như sau: trừ kiểm tra 1 tiết hệ số 2, còn lại tất cả là hệ số 1. Nếu bài kiểm tra nào chưa được cho điểm thì chưa tính vào
điểm GPA.

## Bài tập 5

Trong bài tập này chúng ta sẻ làm quen sử dụng ServletFilter để xác thực và cấp phép cho người dùng trong hệ thống JUNIOR.

Dựa theo các bài tập trước, chung ta cần phần quyền như sau:

- (student) học sinh chỉ xem được các danh sách các course mà học sinh đó tham gia và điểm số của mình ứng với mỗi course
- (teacher) giáo viên có thể xem được danh sách các course mà giáo viên đó giảng dạy, được phép chỉnh sửa nội dung môn học, nhưng không được chỉnh sửa danh sách
học sinh tham gia khóa học đó. Giáo viên có quyền chấm điểm học sinh và lưu trử ghi chú của từng học sinh trong môn học đấy.
- (warden) quản giáo có thể xem được tất cả các course đang có trong hệ thống JUNIOR, được phép chỉnh sửa học sinh tham gia khóa học bất kì, nhưng quản giáo không
được phép chấm điểm học chỉnh sửa ghi chú của bất kì học sinh.

