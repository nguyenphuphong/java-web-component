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
