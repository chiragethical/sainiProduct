<P class="lead">shop name</P>
<div class="sidebar list-group">
<c:forEach items="${categories}" var="category">
<a href=# class="list-group-item">${category.name}</a>
<a href=# class="list-group-item">${category.id}</a>
<a href=# class="list-group-item">${category.description}</a>

</c:forEach>
</div>