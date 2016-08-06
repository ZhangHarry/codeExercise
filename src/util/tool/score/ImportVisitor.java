package util.tool.score;

import org.eclipse.jdt.core.dom.*;

import java.util.*;

/**
 * Created by Zhanghr on 2016/4/6.
 */
public class ImportVisitor extends ASTVisitor {

    private List<String> imports;
    private List<String> allImports;
    private Map<String, String> importsMap;// name->package
    private String packageName;

    boolean imports_ok = false;

    public ImportVisitor(){
        imports = new ArrayList<>();
        allImports = new ArrayList<>();
        importsMap = new HashMap<>();
        String packageName = "";
    }

    public List<String> imports() {
        if (!imports_ok){
            imports_ok = true;
            Set set = importsMap.entrySet();
            Iterator<Map.Entry> it = set.iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                imports.add(entry.getValue()+"."+entry.getKey());
            }
        }
        return imports;
    }

    public String getPackageName() {
        return packageName;
    }
    public boolean visit(ImportDeclaration node) {
        QualifiedName qualifiedName = (QualifiedName)node.getName();
        String name = qualifiedName.getName().toString();
        String qualifier = qualifiedName.getQualifier().toString();
        if (name.equals("*"))
            allImports.add(qualifier);
        else
            importsMap.put(name, qualifier);
        return super.visit(node);
    }

    public boolean visit(PackageDeclaration node) {
        packageName = node.getName().toString();
        return super.visit(node);
    }

    public boolean visit(SimpleType node) {
        return super.visit(node);
    }

}
