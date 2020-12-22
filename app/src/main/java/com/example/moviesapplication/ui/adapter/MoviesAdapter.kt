package com.example.moviesapplication.ui.adapter

//class MoviesAdapter(private val list: ArrayList<TvShow?>) :
//    RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {
//
//    class MoviesHolder(container: ViewGroup) :
//        RecyclerView.ViewHolder(
//            LayoutInflater.from(container.context)
//                .inflate(R.layout.row_movies_list, container, false)
//        ) {
//        private val imageView = itemView.findViewById(R.id.moviesPhoto) as ImageView
//        private val title = itemView.findViewById(R.id.moviesName) as TextView
//
//        fun bind(moviesModel: TvShow, position: Int) {
//            Glide.with(imageView).load(moviesModel.imageThumbnailPath)
//                .into(imageView)
//            title.text = moviesModel.name
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MoviesHolder {
//        return MoviesHolder(parent)
//    }
//
//    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
//        list[position]?.let { holder.bind(it, position) }
//    }
//
//    override fun getItemCount(): Int = list.size
//
//}