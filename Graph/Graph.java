package Graph;

public interface Graph <Type>{
    
    //��ʼ��ͼ
    public Graph init(int Edge);
    //��Ӽ�Ȩ��
    public default void addEdge(int v,int w){
        
    };
    //��ӱ�
    public default void addEdge(Type type){
        
    };
    //��ȡ����
    public int getVertex();
    //��ȡ��
    public int getEdge();
    //��ȡ�ڽӱ�
    public Iterable<Type> adj(int v);
    //toString����
    public String toString();
}
