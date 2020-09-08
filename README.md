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

